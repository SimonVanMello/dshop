import ProductList from '../../components/ProductList/ProductList';

import './HomePage.css';

const HomePage = (): JSX.Element => {
	return (
        <div id="homePageContainer">
			<ProductList />
		</div>
    )
}

export default HomePage;