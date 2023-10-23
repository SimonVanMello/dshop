import NavigationBar from "./components/NavigationBar/NavigationBar";
import AddProductPage from "./pages/AddProductPage/AddProductPage";
import GlobalContextProvider from "./store/GlobalContextProvider";

const App = () => {
	return (
		<GlobalContextProvider>
			<NavigationBar />
			<AddProductPage />
		</GlobalContextProvider>
	);
}

export default App;