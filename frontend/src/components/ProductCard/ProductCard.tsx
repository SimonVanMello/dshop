import { Link } from 'react-router-dom';

import Card from 'react-bootstrap/Card';

import { Product } from '../../types/Product.js';

type ProductCardProps = {
	product: Product
}

const ProductCard = (props: ProductCardProps): JSX.Element => {
	return (
		<Card style={{width: '24rem'}}>
			<Link to={`product/${props.product.id}`} style={{width: '100%', height: '100%'}}>
				<Card.Img
					variant="top"
					src={props.product.imgUrl}
					style={{height: '400px'}}
				/>
			</Link>
			<Card.Body>
				<Card.Title>{props.product.name}</Card.Title>
			</Card.Body>
		</Card>
	)
}

export default ProductCard;