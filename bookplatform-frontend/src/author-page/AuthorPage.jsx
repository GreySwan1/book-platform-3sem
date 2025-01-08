import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import "./AuthorPage.css"
import {getAuthor} from "../api/apiCall.js";
import BookTile from "../books/BookTile.jsx";


function AuthorPage() {

    const [author, setAuthor] = useState();

    useEffect(() => {
        const splitResult = window.location.href.split("/");
        const id = splitResult[splitResult.length - 1];
        getAuthor(id).then(res => setAuthor(res))
    }, []);

    return (
        author && <>
            <Navigation/>
            <div className="authorContainerDiv">
                <div className="authorCoverDiv">
                    <img className="authorPictureImg" src={`data:image/jpeg;base64,${author.picture}`}/>
                </div>
            </div>
            <div className="authorInfoDiv">
                <h1>{`${author.firstName} ${author.patronymic} ${author.lastName}`}</h1>
                <h2>{`${author.dateOfBirth} - ${author.dateOfDeath}`}</h2>
                <p className="authorDescriptionP">
                    {author.biography}
                </p>
            </div>
            <h2 className="reviewsH2">Рецензии пользователей</h2>
            <div className="booksListDiv">
                {
                    author.books.map(
                        (item, key) => {
                            return <BookTile
                                key={key}
                                id={item.id}
                                bookPhoto={item.picture}
                                bookTitle={item.title}
                                bookRating={item.rate}
                            />
                        }
                    )
                }
            </div>
        </>
    )
}

export default AuthorPage;
