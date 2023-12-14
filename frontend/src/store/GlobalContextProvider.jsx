import React from 'react';
import GlobalContext from "./global-context.ts";

const GlobalContextProvider = ({children}) => {
    const globalCtxValue = {
        
    };

    return (
        <GlobalContext.Provider value={globalCtxValue}>
            {children}
        </GlobalContext.Provider>
    )
};

export default GlobalContextProvider;
