import { Link } from 'react-router-dom';
import { Button, Form } from 'react-bootstrap';

import Card from 'react-bootstrap/Card';

import { Product } from '../../types/Product.js';

type ProductCardProps = {
	product: Product
}

const ProductCard = (props: ProductCardProps): JSX.Element => {
	return (
		<Card style={{width: '24rem', display: 'flex'}}>
			<Card.Header>
				<Link to={`product/${props.product.id}`} style={{width: '100%', height: '100%'}}>
					<Card.Img
						variant="top"
						src={props.product.imgUrl}
						style={{width: '100%', height: '100%'}}
					/>
				</Link>
			</Card.Header>
			<Card.Body>
				<div style={{display: 'flex', justifyContent: 'space-between'}}>
					<Card.Title>{props.product.name}</Card.Title>
					<Card.Text>$ {props.product.price}</Card.Text>
				</div>
				<div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
					<Form.Control
						type='number'
						min='1'
						max={props.product.quantity}
						defaultValue='1'
						style={{width: '80px', height: '30px'}}
					/>
					<Button variant='primary' size='sm'>Add to cart</Button>
				</div>
			</Card.Body>
		</Card>
	)
}

export default ProductCard;