import { useState } from 'react';

import { useNavigate } from 'react-router-dom';
import { Button, Spinner } from 'react-bootstrap';
// @ts-ignore
import { api } from '../../constants/api';

import './DeleteProductButton.css';

type DeleteProductButtonProps = {
	id: number;
	setError: (error: string) => void;
}

const DeleteProductButton = ({ id, setError }: DeleteProductButtonProps): JSX.Element => {
	const [isLoading, setIsLoading] = useState<boolean>(false);
	const navigate = useNavigate();

	const handleClick = () => {
		setIsLoading(true);
		fetch(`${api.serverUrl}/product/${id}`, {
			method: 'DELETE',
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

	return (
		<Button
			id="deleteProductButton"
			variant="outline-danger"
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
			Delete
		</Button>
	)
}

export default DeleteProductButton;