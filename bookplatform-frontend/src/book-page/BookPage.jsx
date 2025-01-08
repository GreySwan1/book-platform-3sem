import Navigation from "../navigation/Navigation.jsx";
import {useEffect, useState} from "react";
import "./BookPage.css"
import {getBook} from "../api/apiCall.js";


function BookPage() {

    const [book, setBook] = useState();

    useEffect(() => {
        const splitResult = window.location.href.split("/");
        const id = splitResult[splitResult.length - 1];
        getBook(id).then(res => setBook(res))
    }, []);

    return (
        book && <>
            <Navigation/>
            <div className="bookContainerDiv">
                <div className="bookCoverDiv">
                    <img className="bookPictureImg" src={`data:image/jpeg;base64,${book.picture}`}/>
                </div>
            </div>
            <div className="bookInfoDiv">
                <h1>{book.title}</h1>
                <h2>{`${book.author.firstName} ${book.author.lastName}`}</h2>
                <div className="bookRatingDiv">{book.rate}</div>
                <p>Год публикации: {book.yearOfPublish}</p>
                <p>Жанр: {book.genre}</p>
                <p>Язык оригинала: {book.language}</p>
                <p className="bookDescriptionP">
                    {book.description}
                </p>
            </div>
            <h2 className="reviewsH2">Рецензии пользователей</h2>
            <div className="reviewContainerDiv">
                {
                    book.reviews.map((item, key) => {
                            return <div key={item.id} className="reviewDiv">
                                        <div className="reviewAuthorDiv">
                                            <img className="reviewAvatarImg" src={`data:image/jpeg;base64,${item.user.picture}`}/>
                                            <p className="reviewerUsername">{item.user.login}</p>
                                        </div>
                                        <p className="reviewTextP">{item.text}</p>
                                    </div>
                        }
                    )
                }
            </div>
        </>
    )
}

export default BookPage;
