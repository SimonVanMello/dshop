import Table from 'react-bootstrap/Table';

import { Product } from "../../types/Product";

import "./ProductDetailsTable.css"

type ProductDetailsTableProps = {
	product: Product
}

const ProductDetailsTable = ({product}: ProductDetailsTableProps): JSX.Element => {
	return (
		<div style={{width: "100%"}}>
			<img src={product.imgUrl} style={{width: "20rem", marginBottom: "20px"}} alt="#" />
            <Table striped bordered>
				<tbody>
				<tr>
					<td>Name</td>
					<td>
						<input type="text" defaultValue={product.name}/>
					</td>
				</tr>
				<tr>
					<td>Price</td>
					<td>
						<input id='inputNumber' type="number" step={0.01} defaultValue={product.price}/>
						<label htmlFor="inputNumber">€</label>
					</td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td>
						<input type="number" step={1} defaultValue={product.quantity}/>
					</td>
				</tr>
				</tbody>
            </Table>
		</div>
	)
}

export default ProductDetailsTable;