import { BrowserRouter, Route, Routes } from "react-router-dom";

import HomePage from "./pages/HomePage/HomePage";
import GlobalContextProvider from "./store/GlobalContextProvider";
import AddProductPage from "./pages/AddProductPage/AddProductPage";
import NavigationBar from "./components/NavigationBar/NavigationBar";
import ProductDetailsPage from "./pages/ProductDetailsPage/ProductDetailsPage";

const App = () => {
	return (
		<GlobalContextProvider>
			<BrowserRouter>
				<NavigationBar />
				<Routes>
					<Route path='/' element={<HomePage />} exact />
					<Route path='/newproduct' element={<AddProductPage />} exact />
					<Route path="/product/:id" element={<ProductDetailsPage />} />
				</Routes>
			</BrowserRouter>
		</GlobalContextProvider>
	);
}

export default App;