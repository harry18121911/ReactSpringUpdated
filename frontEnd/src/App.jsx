
import './App.css'
import Header from './components/Header'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import Footer from './components/Footer';
import {BrowserRouter,Routes,Route} from "react-router-dom"
import EmployeeComponent from './components/EmployeeComponent';
 
function App() {
  

  return (
    <>
    <BrowserRouter>
    <Header/>
    <Routes>
      
      <Route path='/' element = {<ListEmployeeComponent/>}></Route>
      <Route path='/employees' element = {<ListEmployeeComponent/>}></Route>
      <Route path='/add-employee' element= {<EmployeeComponent/>}></Route>
      <Route path='/edit-employee/:id' element= {<EmployeeComponent/>}></Route>
    </Routes>
     
      <Footer/>
      </BrowserRouter>
    </>
  )
}

export default App
