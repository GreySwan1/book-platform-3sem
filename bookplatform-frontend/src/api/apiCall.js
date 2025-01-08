
const BACKEND_URL = "http://localhost:8080"

export function getBooks() {
    return sendApiRequest('GET', '/api/v1/books');
}

export function getBook(id) {
    return sendApiRequest('GET', '/api/v1/books/' + id);
}

export function getAuthors() {
    return sendApiRequest('GET', '/api/v1/authors');
}

export function getAuthor(id) {
    return sendApiRequest('GET', '/api/v1/authors/' + id);
}

export function getUsers() {
    return sendApiRequest('GET', '/api/v1/users');
}

export function getUser(id) {
    return sendApiRequest('GET', '/api/v1/users/' + id);
}


async function sendApiRequest(method, uri, body = null) {
    const apiUrl = BACKEND_URL + uri;

    if (body != null) {
        return fetch(
            apiUrl,
            {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)
            }
        ).then(res => res.json());
    } else {
        return fetch(
            apiUrl,
            {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        ).then(res => res.json());
    }

}