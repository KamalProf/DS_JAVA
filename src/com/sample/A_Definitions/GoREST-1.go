package main

import (
    "database/sql"
    "encoding/json"
    "fmt"
    "log"
    "net/http"

    "github.com/gorilla/mux"
    _ "github.com/lib/pq"
)

const (
    DB_USER     = "postgres"
    DB_PASSWORD = "12345678"
    DB_NAME     = "movies"
)

// DB set up
func setupDB() *sql.DB {
    dbinfo := fmt.Sprintf("user=%s password=%s dbname=%s sslmode=disable", DB_USER, DB_PASSWORD, DB_NAME)
    db, err := sql.Open("postgres", dbinfo)

    checkErr(err)
    return DB
}

type Movie struct {
    MovieID   string `json:"movieid"`
    MovieName string `json:"moviename"`
}

type JsonResponse struct {
    Type    string `json:"type"`
    Data    []Movie `json:"data"`
    Message string `json:"message"`
}

// Main function
func main() {
    // Init the mux router
    router := mux.NewRouter()
	// Route handles & endpoints
    // Get all movies
    router.HandleFunc("/movies/", GetMovies).Methods("GET")
    // Create a movie
    router.HandleFunc("/movies/", CreateMovie).Methods("POST")
    // serve the app
    fmt.Println("Server at 8080")
    log.Fatal(http.ListenAndServe(":8000", router))
}
// Function for handling messages
func printMessage(message string) {
    fmt.Println("")
    fmt.Println(message)
    fmt.Println("")
}
// Function for handling errors
func checkErr(err error) {
    if err != nil {
        panic(err)
    }
}
// Create a movie
// response and request handlers
func CreateMovie(w http.ResponseWriter, r *http.Request) {
	var response = JsonResponse{}
	
    movieID := r.FormValue("movieid")
    movieName := r.FormValue("moviename")
    if movieID == "" || movieName == "" {
        response = JsonResponse{Type: "error", Message: "You are missing movieID or movieName parameter."}
    } else {
        db := setupDB()
        printMessage("Inserting movie into DB")
        fmt.Println("Inserting new movie with ID: " + movieID + " and name: " + movieName)
        var lastInsertID int
	    err := db.QueryRow("INSERT INTO movies(movieID, movieName) VALUES($1, $2) returning id;", movieID, movieName).Scan(&lastInsertID)
	    // check errors
		checkErr(err)
	    response = JsonResponse{Type: "success", Message: "The movie has been inserted successfully!"}
    }
    json.NewEncoder(w).Encode(response)
}

// response and request handlers
func GetMovies(w http.ResponseWriter, r *http.Request) {
    db := setupDB()
    printMessage("Getting movies...")
    // Get all movies from movies table that don't have movieID = "1"
    rows, err := db.Query("SELECT * FROM movies")
    // check errors
    checkErr(err)
    // var response []JsonResponse
    var movies []Movie
    // Foreach movie
    for rows.Next() {
        var id int
        var movieID string
        var movieName string
        err = rows.Scan(&id, &movieID, &movieName)
        // check errors
        checkErr(err)
        movies = append(movies, Movie{MovieID: movieID, MovieName: movieName})
    }
    var response = JsonResponse{Type: "success", Data: movies}
    json.NewEncoder(w).Encode(response)
}



