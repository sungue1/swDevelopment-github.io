import {BrowserRouter, Routes, Route} from "react-router-dom";
import Main from "./Pages/Main";
import Detail from "./Pages/Detail";
import Header from "./Component/Header";
import Preview from "./Pages/Preview";
import Notfound from "./Pages/Notfound";
function Routing() {
    return (
        <div className = 'root-warp'>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Preview />} />
                    <Route path='main' element={<Main />} />
                    <Route path='main/detail/:title' element={<Detail/>} />
                    <Route path='/*' element={<Notfound />} />
                </Routes>
                <Header />
            </BrowserRouter>
        </div>
    )
}

export default Routing;