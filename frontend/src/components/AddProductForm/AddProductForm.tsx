import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import AddedProductAlert from '../AddedProductAlert/AddedProductAlert.tsx';

import './AddProductForm.css';

const AddProductForm = () : JSX.Element => {
    const [validated, setValidated] = useState(false);
    const [showAddedProductAlert, setShowAddedProductAlert] = useState(false);

    const handleSubmit = (event: any) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        } else{
            event.preventDefault();
            const formData = new FormData(event.target);
            const formDataObj = Object.fromEntries(formData.entries())
            console.log(formDataObj);
            fetch('https://virtserver.swaggerhub.com/SimonVanMello/dshop/1.0.0/product', {
                method: 'post',
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(formDataObj)
            }).then(response => {
                console.log(response);
                if (response.status == 200){
                    setShowAddedProductAlert(true);
                }
            })
        }
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