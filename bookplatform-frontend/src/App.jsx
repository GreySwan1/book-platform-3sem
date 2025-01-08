import {BrowserRouter, Route, Routes} from "react-router-dom";
import Books from "./books/Books.jsx";
import Authors from "./authors/Authors.jsx";
import BookPage from "./book-page/BookPage.jsx";
import Users from "./users/Users.jsx";
import AuthorPage from "./author-page/AuthorPage.jsx";
import UserPage from "./user-page/UserPage.jsx";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Books/>}/>
        <Route path="/books" element={<Books/>}/>
        <Route path="/books/:id" element={<BookPage/>}/>
        <Route path="/authors" element={<Authors/>}/>
        <Route path="/authors/:id" element={<AuthorPage/>}/>
        <Route path="/users" element={<Users/>}/>
        <Route path="/users/:id" element={<UserPage/>}/>
      </Routes>

    </BrowserRouter>
  )
}

export default App
