import Table from 'react-bootstrap/Table';

import { Product } from "../../types/Product";

import "./ProductDetailsTable.css"
import { useState } from 'react';

type ProductDetailsTableProps = {
	product: Product
}

const ProductDetailsTable = ({product}: ProductDetailsTableProps): JSX.Element => {
	const [name,setName] = useState(product.name)
	const [price,setPrice] = useState(product.price)
	const [quantity,setQuantity] = useState(product.quantity)
	const [img,setImg] = useState(product.img)

	product.name = name
	product.price = price
	product.quantity = quantity
	product.img = img
	
	function preview(e: React.ChangeEvent<HTMLInputElement>){
		var input = document.getElementById('inputImage') as HTMLInputElement;
		if (input.files && input.files[0]) {   
            var reader = new FileReader();           
            reader.onload = function(e) {              
                var preview = document.getElementById('ProductDetailsTableImg');
                preview.src = e.target.result;
				setImg(input)
            };
            reader.readAsDataURL(input.files[0]);
		}
	}
	return (
		<div style={{width: "100%"}}>
			<input type="file" id="inputImage" accept="image/*" onChange={preview}/>
			<img src={product.imgUrl} style={{width: "20rem", marginBottom: "20px"}} alt="#" id='ProductDetailsTableImg'/>
            <Table striped bordered>
				<tbody>
				<tr>
					<td>Name</td>
					<td>
						<input type="text" defaultValue={product.name} onChange={(e)=>{setName(e.target.value)}}/>
					</td>
				</tr>
				<tr>
					<td>Price</td>
					<td>
						<input id='inputNumber' type="number" step={0.01} defaultValue={product.price} onChange={(e)=>{setPrice(parseFloat(e.target.value))}}/>
						<label htmlFor="inputNumber">€</label>
					</td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td>
						<input type="number" step={1} defaultValue={product.quantity} onChange={(e)=>{setQuantity(parseFloat(e.target.value))}}/>
					</td>
				</tr>
				</tbody>
            </Table>
		</div>
	)
}

export default ProductDetailsTable;