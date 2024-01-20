import { useState } from 'react';

import { useNavigate } from 'react-router-dom';
import { Button, Spinner } from 'react-bootstrap';
// @ts-ignore
import { api } from '../../constants/api';

import './ModifyProductButton.css';
import { Product } from "../../types/Product";

type ModifyProductButtonProps = {
	product: Product;
	setError: (error: string) => void;
}

const ModifyProductButton = ({ product, setError }: ModifyProductButtonProps): JSX.Element => {
	const [isLoading, setIsLoading] = useState<boolean>(false);

	const navigate = useNavigate();

	function handleClick() {
		setIsLoading(true);
		const formData = new FormData();
		if (product.img === null || product.img === undefined){
			fetch(product.imgUrl)
			.then((response) => {
				if (!response.ok) {
				throw new Error(`Erreur de chargement de l'image: ${response.status}`);
				}
				return response.blob();
			}).then((responseBlob)=>{
				formData.append('img',responseBlob);
				formData.append('name', product.name);
				formData.append('price', product.price.toString());
				formData.append('quantity', product.quantity.toString());
				fetch(`${api.serverUrl}/product/${product.id}`, {
					method: 'PUT',
					body : formData
				})
				.then(res => {
					if (res.status === 200) {
						setIsLoading(false);
						navigate('/');
						return '';
					}
					return res.text();
				})
				.then(res => {
					if (!res) return;
					setError(res);
				})
				.catch(error => {
					setIsLoading(false);
					setError(error.toString());
				})
			})
		} else {
			formData.append('img',product.img.files[0]);
			formData.append('name', product.name);
			formData.append('price', product.price.toString());
			formData.append('quantity', product.quantity.toString());
			fetch(`${api.serverUrl}/product/${product.id}`, {
				method: 'PUT',
				body : formData
			})
			.then(res => {
				if (res.status === 200) {
					setIsLoading(false);
					navigate('/');
					return '';
				}
				return res.text();
			})
			.then(res => {
				if (!res) return;
				setError(res);
			})
			.catch(error => {
				setIsLoading(false);
				setError(error.toString());
			})
		}
	  }
	return (
		<Button
			id="modifyProductButton"
			variant="outline-success"
			size='lg' 
			onClick={handleClick}
			disabled={isLoading}
		>
			<Spinner
				animation="border"
				role="status"
				size="sm"
				style={{ display: isLoading ? 'inline-block': 'none', marginRight: '5px' }}
			/>
			Modify
		</Button>
	)
}

export default ModifyProductButton;