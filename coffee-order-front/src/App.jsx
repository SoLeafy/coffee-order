import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Home from "./pages/Home";
import Login from "./pages/Login";
import SelectCafe from "./pages/host/SelectCafe";
import SelectMenu from "./pages/host/SelectMenu";
import CreateComplete from "./pages/host/CreateComplete";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/create/select-cafe" element={<SelectCafe />} />
        <Route path="/create/select-menu" element={<SelectMenu />} />
        <Route path="/create/complete" element={<CreateComplete />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
