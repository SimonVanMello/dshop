import GlobalContext from "./global-context.ts";

type GlobalContextProviderProps = {
    children: JSX.Element
}

const GlobalContextProvider = ({children}: GlobalContextProviderProps): JSX.Element => {
    const globalCtxValue = {
        
    };

    return (
        <GlobalContext.Provider value={globalCtxValue}>
            {children}
        </GlobalContext.Provider>
    )
};

export default GlobalContextProvider;
