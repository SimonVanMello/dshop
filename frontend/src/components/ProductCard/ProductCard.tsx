import Card from 'react-bootstrap/Card';

import { Product } from '../../types/Product.js';

type ProductCardProps = {
	product: Product
}

const ProductCard = (props: ProductCardProps): JSX.Element => {
	return (
		<Card style={{width: '24rem'}}>
			<Card.Img
				variant="top"
				src={props.product.imgUrl}
				style={{height: '400px'}}
			/>
			<Card.Body>
				<Card.Title>{props.product.name}</Card.Title>
			</Card.Body>
		</Card>
	)
}

export default ProductCard;