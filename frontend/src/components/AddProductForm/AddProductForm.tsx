import { useState } from 'react';

import { useNavigate } from 'react-router-dom';

import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
// @ts-ignore
import { api } from '../../constants/api.js';

import './AddProductForm.css';
import { Alert, Spinner } from 'react-bootstrap';

const AddProductForm = (): JSX.Element => {
    const [validated, setValidated] = useState<boolean>(false);
	const [error, setError] = useState<string>('');
	const [isLoading, setIsLoading] = useState<boolean>(false);
	const navigate = useNavigate();

    const handleSubmit = (event: any): void => {
        event.preventDefault();
		setIsLoading(true);
		setError('');
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.stopPropagation();
            return;
        }

        const formData = new FormData(event.target);
        formData.delete("img");
        const imgInput: HTMLInputElement = document.getElementById("AddProductForm.img") as HTMLInputElement;
        if (imgInput.files != null){

            formData.append("img", imgInput.files[0]);
        }
		setValidated(true);

        fetch(`${api.serverUrl}/product`, {
            method: 'post',
            headers: {
                'Accept': '*/*',
            },
            body: formData
        })
		.then(response => {
            if (response.status == 201){
				navigate('/');
				setIsLoading(false);
				return '';
            }
			return response.text();
        })
		.then(response => {
			if (!response) return;
			setError(response);
			setIsLoading(false);
			form.reset();
		})
		.catch(error => {
			setError(error);
			setIsLoading(false);
		});
    };

    return (
		<div className="formContainer">
            <Form noValidate onSubmit={handleSubmit} validated={validated}>
                <Form.Group className="mb-3" controlId="AddProductForm.name">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter name" name="name" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.price">
                    <Form.Label>Price</Form.Label>
                    <Form.Control type="number" step="0.01" placeholder="Enter price" min="0" name="price" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.quantity">
                    <Form.Label>Quantity</Form.Label>
                    <Form.Control type="number" placeholder="Enter quantity" min="0" name="quantity" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.img">
                    <Form.Label>Image</Form.Label>
                    <Form.Control type="file" placeholder="Enter image" accept=".jpg,.jpeg,.png" name="img" required />
                </Form.Group>

                <Button variant="primary" type="submit" style={{width: '100%', marginTop: '20px'}}>
					<Spinner
						animation="border"
						role="status"
						size="sm"
						style={{ display: isLoading ? 'inline-block': 'none', marginRight: '5px' }}
					/>
                    Submit
                </Button>
			{error && (
				<Alert variant="danger" style={{marginTop: '20px'}}>
					{error}
				</Alert>
			)}
            </Form>
        </div>
    )
};

export default AddProductForm;
