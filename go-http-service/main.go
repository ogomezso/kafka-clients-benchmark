package main

import (
	"bytes"
	"io/ioutil"
	"log"
	"net/http"
	"time"
)

func handler(w http.ResponseWriter, r *http.Request) {
	html := "done"
	w.Write([]byte(html))
}

func RequestLogger(targetMux http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		start := time.Now()

		targetMux.ServeHTTP(w, r)

		// log request by who(IP address)
		requesterIP := r.RemoteAddr
		log.Println("---------------------REQUEST-----------------------------")
		log.Printf(
			"METHOD:%s\t\t%s\t\t%s\t\t%v",
			r.Method,
			r.RequestURI,
			requesterIP,
			time.Since(start),
		)

		log.Printf("HEADERS")
		for name, headers := range r.Header {
			for _, h := range headers {
				log.Printf("%v: %v", name, h)
			}
		}

		buf, bodyErr := ioutil.ReadAll(r.Body) // read request body
		if bodyErr != nil {
			log.Print("bodyErr ", bodyErr.Error())
			http.Error(w, bodyErr.Error(), http.StatusInternalServerError)
			return
		}

		rdr1 := ioutil.NopCloser(bytes.NewBuffer(buf))
		rdr2 := ioutil.NopCloser(bytes.NewBuffer(buf))
		log.Printf("BODY: %q", rdr1)
		r.Body = rdr2
		log.Println("-------------------------------------------------------")
	})
}

func main() {
	addr := ":8080"
	mux := http.NewServeMux()
	mux.HandleFunc("/", handler)
	log.Println("listen on", addr)
	log.Fatal(http.ListenAndServe(":8080", RequestLogger(mux)))
}
