import Card from 'react-bootstrap/Card';
import Placeholder from 'react-bootstrap/Placeholder';

const ProductCardPlaceholder = (): JSX.Element => {
	return (
		<Card style={{width: '24rem'}}>
			<Card.Img
				variant="top"
				src="https://dummyimage.com/600x600/b8b8b8/ffffff.gif"
				style={{height: '100%', width: '100%'}}
			/>
			<Card.Body>
				<Placeholder as={Card.Title} animation="glow">
					<Placeholder xs={8} />
				</Placeholder>
			</Card.Body>
		</Card>
	)
}

export default ProductCardPlaceholder;