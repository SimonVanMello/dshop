import { useEffect, useState } from 'react';

import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Alert from 'react-bootstrap/Alert';
import Spinner from 'react-bootstrap/Spinner';

// @ts-ignore
import { api } from '../../constants/api.js';
import { Product } from '../../types/Product.js';

import './ProductList.css';
import ProductCard from '../ProductCard/ProductCard.js';

const ProductList = (): JSX.Element => {
	const [error, setError] = useState<string>('');
	const [isLoading, setIsLoading] = useState<boolean>(true);
	const [products, setProducts] = useState<Array<Product>>([]);

	useEffect(() => {
		fetch(`${api.serverUrl}/product`)
		.then(res => {
			setIsLoading(false);
			switch(res.status){
				case 200: 
					setError('');
					return res.json()
				case 401:
					setError('Error: You need to be authenticated to access this ressource.');
					return false
				case 403:
					setError('Error: You are not authorized to access this ressource.');
					return false
				case 404:
					setError('Error: Unknown route.');
					return false
			}
		})
		.then(res => {
			if (!res) return
			setProducts(res);
		})
		.catch(error => {
			setIsLoading(false);
			setError(error.toString());
		})
	}, []);

	if (isLoading){
		return(
			<Spinner animation="border" role="status">
				<span className="visually-hidden">Loading...</span>
			</Spinner>
		)
	}

	if (error){
		return (
			<Alert variant="danger">
				<Alert.Heading>Oh snap! You got an error!</Alert.Heading>
				<p>{error}</p>
			</Alert>
		)
	}

	return (
		<div id="productList">
			<Row xs={1} md={3} className="g-4">
			{products.map(product => (
				<Col key={product.id} style={{display: "flex", justifyContent: "center"}}>
					<ProductCard product={product} />
				</Col>
			))}
			</Row>
		</div>
	)
}

export default ProductList;