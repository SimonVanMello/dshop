import Table from 'react-bootstrap/Table';

import { Product } from "../../types/Product";

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
					<td>{product.name}</td>
				</tr>
				<tr>
					<td>Price</td>
					<td>{product.price} €</td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td>{product.quantity}</td>
				</tr>
				</tbody>
            </Table>
		</div>
	)
}

export default ProductDetailsTable;