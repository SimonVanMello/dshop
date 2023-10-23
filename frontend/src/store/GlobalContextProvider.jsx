import React from 'react';
import GlobalContext from "./global-context.ts";

const GlobalContextProvider = ({children}) => {
    const globalCtxValue = {
        serverUrl: "https://virtserver.swaggerhub.com/SimonVanMello/dshop/1.0.0"
    };

    return (
        <GlobalContext.Provider value={globalCtxValue}>
            {children}
        </GlobalContext.Provider>
    )
};

export default GlobalContextProvider;