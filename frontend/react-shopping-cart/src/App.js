import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
//import { ProtectedRoute, AdminRoute } from './service/Guard';
import Navbar from './component/common/Navbar';
import Footer from './component/common/footer';
import { CartProvider } from './component/context/CardContext';
import Home from './component/pages/Home';
import ProductDetailsPage from './component/pages/ProductDetailsPage';
import CategoryListPage from './component/pages/CategoryListPage';
import CategoryProductsPage from './component/pages/CategoryProductsPage';
import CartPage from './component/pages/CartPage';
//import RegisterPage from './component/pages/RegisterPage';
//import LoginPage from './component/pages/LoginPage';
// import ProfilePage from './component/pages/ProfilePage';
// import AddressPage from './component/pages/AddressPage';
// import AdminPage from './component/admin/AdminPage';
// import AdminCategoryPage from './component/admin/AdminCategoryPage';
// import AddCategory from './component/admin/AddCategory';
// import EditCategory from './component/admin/EditCategory';
// import AdminProductPage from './component/admin/AdminProductPage';
// import AddProductPage from './component/admin/AddProductPage';
// import EditProductPage from './component/admin/EditProductPage';
// import AdminOrdersPage from './component/admin/AdminOrderPage';
// import AdminOrderDetailsPage from './component/admin/AdminOrderDetailsPage';

function App() {
  return (
    <BrowserRouter>
    <CartProvider>
      <Navbar/>
        <Routes>
          {/* OUR ROUTES */}
          <Route exact path='/' element={<Home/>}/> 
          <Route path='/product/:productId' element={<ProductDetailsPage/>} />
          <Route path='/categories' element={<CategoryListPage/>}/>
          <Route path='/category/:categoryId' element={<CategoryProductsPage/>} />
          <Route path='/cart' element={<CartPage/>}/>
         </Routes>
      <Footer/>
    </CartProvider>
    </BrowserRouter>
  );
}

export default App;
