import React from 'react'
import logoImg from "../../assets/images/Goku-E.png"
import "./styles.css"

function Landing(){
    return(
    <div id="page-landing">
        <div id="page-landing-content" className ="container">

        <div id="logo-container">
            <img 
            src={logoImg} 
            alt="Goku E-commerce"
            className="goku-image"
            />
        </div>
        <div className="buttons-container">
            <a href="/Cadastre" className="cadastre">
                Cadastre
            </a>
            <a href="/Encontre" className="encontre">
                Encontre
            </a>
        </div>
    </div>
</div>
)}
export default Landing;
