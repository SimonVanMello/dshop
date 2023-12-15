import { Link } from 'react-router-dom';

import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import NavDropdown from 'react-bootstrap/NavDropdown';

const NavigationBar = () => {
	return (
    	<Navbar bg="light" data-bs-theme="light" id="NavBarContainer">
			<Container>
			<Navbar.Brand as={Link} to="/">Dshop</Navbar.Brand>
				<Nav className="me-auto">
					<Nav.Link as={Link} to="/">Home</Nav.Link>
					<Nav.Link as={Link} to="/">Features</Nav.Link>
					<Nav.Link as={Link} to="/">Pricing</Nav.Link>
					<NavDropdown title="Admin" id="basic-nav-dropdown">
						<NavDropdown.Item as={Link} to="/newproduct">
							Add new product
						</NavDropdown.Item>
					</NavDropdown>
				</Nav>
			</Container>
      </Navbar>
  	);
}

export default NavigationBar;