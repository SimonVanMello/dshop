import React, { useState, useContext } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import GlobalContext from '../../store/global-context.ts';
import AddedProductAlert from '../AddedProductAlert/AddedProductAlert.tsx';

import './AddProductForm.css';


const AddProductForm = (): JSX.Element => {
    const [validated, setValidated] = useState(false);
    const [showAddedProductAlert, setShowAddedProductAlert] = useState(false);

    const {serverUrl} = useContext(GlobalContext);

    const handleSubmit = (event: any): void => {
        event.preventDefault();
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.stopPropagation();
            return;
        }

        const formData = new FormData(event.target);
        formData.delete("img");
        const imgInput: HTMLInputElement = document.getElementById("AddProductForm.img") as HTMLInputElement;
        formData.append("img", imgInput.files[0]);
        console.log(formData);
        

        fetch(`${serverUrl}/product`, {
            method: 'post',
            headers: {
                'Accept': '*/*',
            },
            body: formData
        }).then(response => {
            console.log(response);
            if (response.status == 201){
                setShowAddedProductAlert(true);
            }
        })
        
        setValidated(true);
    };

    return (
        <div className="formContainer">
            {showAddedProductAlert && <AddedProductAlert showAddedProductAlert={showAddedProductAlert} setShowAddedProductAlert={setShowAddedProductAlert} />}
            <Form noValidate onSubmit={handleSubmit} validated={validated}>
                <Form.Group className="mb-3" controlId="AddProductForm.name">
                    <Form.Label>Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter name" name="name" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.price">
                    <Form.Label>Price</Form.Label>
                    <Form.Control type="number" placeholder="Enter price" min="0" name="price" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.quantity">
                    <Form.Label>Quantity</Form.Label>
                    <Form.Control type="number" placeholder="Enter quantity" min="0" name="quantity" required />
                </Form.Group>

                <Form.Group className="mb-3" controlId="AddProductForm.img">
                    <Form.Label>Image</Form.Label>
                    <Form.Control type="file" placeholder="Enter image" accept=".jpg,.jpeg,.png" name="img" required />
                </Form.Group>

                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    )
};

export default AddProductForm;