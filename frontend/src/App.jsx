import HomePage from "./pages/HomePage/HomePage";
import GlobalContextProvider from "./store/GlobalContextProvider";
import AddProductPage from "./pages/AddProductPage/AddProductPage";
import NavigationBar from "./components/NavigationBar/NavigationBar";

const App = () => {
	return (
		<GlobalContextProvider>
			<NavigationBar />
			{/* <AddProductPage /> */}
			<HomePage />
		</GlobalContextProvider>
	);
}

export default App;