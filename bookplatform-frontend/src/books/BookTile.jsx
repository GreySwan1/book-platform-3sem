import "./BookTile.css"

function BookTile(props) {

    const { id, bookPhoto, bookTitle, bookAuthor, bookRating } = props;

    return (
        <div className="bookTileDiv">
            <img className="bookTileImg" src={`data:image/jpeg;base64,${bookPhoto}`}/>
            <div className="bookDescriptionDiv">
                <h2><a href={"/books/" + id}>{bookTitle}</a></h2>
                <p>{bookAuthor}</p>
            </div>
            <div className="stars">{bookRating}</div>
        </div>
    )
}

export default BookTile;