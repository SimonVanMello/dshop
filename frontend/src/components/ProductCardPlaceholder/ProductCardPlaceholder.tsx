import Card from 'react-bootstrap/Card';
import Placeholder from 'react-bootstrap/Placeholder';

const ProductCardPlaceholder = (): JSX.Element => {
	return (
		<Card style={{width: '24rem'}}>
			<Card.Header>
				<Card.Img
					variant="top"
					src="https://dummyimage.com/600x600/b8b8b8/ffffff.gif"
					style={{height: '100%', width: '100%'}}
				/>
			</Card.Header>
			<Card.Body>
				<Placeholder as={Card.Title} animation="glow" style={{display: 'flex', justifyContent: 'space-between'}}>
					<Placeholder xs={5} />
					<Placeholder xs={2} />
				</Placeholder>
				<Placeholder as={Card.Text} animation="glow" style={{display: 'flex', justifyContent: 'space-between'}}>
					<Placeholder xs={4} />
					<Placeholder.Button variant="primary" xs={4} />
				</Placeholder>
			</Card.Body>
		</Card>
	)
}

export default ProductCardPlaceholder;