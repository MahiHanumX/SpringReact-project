import React, {useState} from "react";
import '../../style/navbar.css';
import { NavLink, useNavigate } from "react-router-dom";
const Navbar = () =>{

    const [searchValue, setSearchValue] = useState("");
    const navigate = useNavigate();
    const handleSearchChange =(e) => {
        setSearchValue(e.target.value);
    }

    const handleSearchSubmit = async (e) =>{
        e.preventDefault();
        navigate(`/?search=${searchValue}`)
    }
    return(
        <nav className="navbar">
            <div className="navbar-brand">
                <NavLink to="/" > <img src="./shopes_mart.png" alt="shopping Mart" /></NavLink>
            </div>
            {/* SEARCH FORM */}
            <form className="navbar-search" onSubmit={handleSearchSubmit}>
                <input type="text" 
                placeholder="Search products" 
                value={searchValue}
                onChange={handleSearchChange} />
                <button type="submit">Search</button>
            </form>

            <div className="navbar-link">
                <NavLink to="/" >Home</NavLink>
                <NavLink to="/categories" >Categories</NavLink>
                <NavLink to="/cart">Cart</NavLink>
            </div>
        </nav>
    );

};
export default Navbar;