import { useEffect, useState } from 'react';

import { useParams } from 'react-router-dom';

import Alert from 'react-bootstrap/Alert';
import Spinner from 'react-bootstrap/Spinner';

// @ts-ignore
import { api } from '../../constants/api.js';
import { Product } from '../../types/Product';
import DeleteProductButton from '../../components/DeleteProductButton/DeleteProductButton';
import ProductDetailsTable from '../../components/ProductDetailsTable/ProductDetailsTable';

import './ProductDetailsPage.css';

const ProductDetailsPage = (): JSX.Element => {
	const { id } = useParams();
	const [product, setProduct] = useState<Product>();
	const [error, setError] = useState<string>('');
	const [isLoading, setIsLoading] = useState<boolean>(true);

	useEffect(() => {
		fetch(`${api.serverUrl}/product/${id}`)
		.then(res => {
			setIsLoading(false);
			switch(res.status){
				case 200: 
					setError('');
					return res.json()
				case 400:
					setError('Error: This product does not exist.');
					return false
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
			setProduct(res);
		})
		.catch(error => {
			setIsLoading(false);
			setError(error.toString());
		})
	}, []);

	if (error){
		return (
			<div id="productDetailsPageContainer">
				<Alert variant="danger">
					<Alert.Heading>Oh snap! You got an error!</Alert.Heading>
					<p>{error}</p>
				</Alert>
			</div>
		)
	}

	if (product && !isLoading){
		return (
			<div id="productDetailsPageContainer">
				<div id="productDetailsPageInnerContainer">
					<ProductDetailsTable product={product} />
					{product.id && <DeleteProductButton id={product.id} setError={setError} />}
				</div>
			</div>
		)
	}

	return (
		<div id="productDetailsPageContainer">
			<Spinner animation="border" role="status">
				<span className="visually-hidden">Loading...</span>
			</Spinner>
		</div>
	)
}

export default ProductDetailsPage;