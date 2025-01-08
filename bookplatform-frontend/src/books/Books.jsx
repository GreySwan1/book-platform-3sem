import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import {getBooks} from "../api/apiCall.js";
import BookTile from "./BookTile.jsx";
import "./Books.css"


function Books() {

    const [books, setBooks] = useState();

    useEffect(() => {
        getBooks().then(res => setBooks(res))
    }, []);

    return (
        books && <>
            <Navigation/>
            <div className="booksContainer">
                <h1>Книги</h1>
                <div className="booksListDiv">
                    {
                        books.books.map(
                            (item, key) => {
                                return <BookTile
                                    key={key}
                                    id={item.id}
                                    bookPhoto={item.picture}
                                    bookTitle={item.title}
                                    bookAuthor={`${item.author.firstName} ${item.author.lastName} `}
                                    bookRating={item.rate}
                                />
                            }
                        )
                    }
                </div>
            </div>
        </>
    )
}

export default Books;
