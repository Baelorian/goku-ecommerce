import React from 'react';
import {BrowserRouter, Route } from  'react-router-dom';

import Landing from './pages/Landing';
import Cadastre from './pages/Cadastre';
import Encontre from './pages/Encontre';

function Routes(){
    return(
        <BrowserRouter>
            <Route path="/" exact component={Landing} />
            <Route path="/Cadastre" component={Cadastre} />
            <Route path="/Encontre" component={Encontre} />
        </BrowserRouter>
    )
}

export default Routes