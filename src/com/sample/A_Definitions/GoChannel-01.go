package main

import (  
    "fmt"
)

================================================
// Deadlock
var wg sync.WaitGroup
func main() {   
    wg.Add(1)
    c := make(chan int)
    go readFromChannel(c, time.After(time.Duration(2)*time.Second))
    time.Sleep(time.Duration(5) * time.Second)
    c <- 10
    wg.Wait()
}

func readFromChannel(c chan int, ti <-chan time.Time) {
    select {
    case x := <-c:
        fmt.Println("Read", x)
    case <-ti:
        fmt.Println("TIMED OUT")
    }
    wg.Done()
}
================================================
//Resolve Deadlock
func main() {
    wg.Add(1)
    c := make(chan int)
    go readFromChannel(c, time.After(time.Duration(2)*time.Second))
    time.Sleep(time.Duration(5) * time.Second)
    c <- 10
    wg.Wait()
}

func readFromChannel(c chan int, ti <-chan time.Time) {
        // the forloop will run forever
    loop: // **
    for {
        select {
            case x := <-c:
                    fmt.Println("Read", x)
                    break loop // breaks out of the for loop and the select **
            case <-ti:
                    fmt.Println("TIMED OUT")
            }
    }
    wg.Done()
} 
=================================================
// Unidirectional channels

package main

import "fmt"

func sendData(sendch chan<- int) {  
    sendch <- 10
}

func main() {  
    sendch := make(chan<- int)
    go sendData(sendch)
    fmt.Println(<-sendch)
}
=================================================

// Closing channels and for range loops on channels
func producer(chnl chan int) {  
    for i := 0; i < 10; i++ {
        chnl <- i
    }
    close(chnl)
}
func main() {  
    ch := make(chan int)
    go producer(ch)
    for {
        v, ok := <-ch
        if ok == false {
            break
        }
        fmt.Println("Received ", v, ok)
    }
}
================================================

