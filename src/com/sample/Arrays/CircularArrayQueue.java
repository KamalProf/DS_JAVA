package com.sample.Arrays;

public class CircularArrayQueue {
	int size,rear,front;
	int[] queue = new int[100];
	
	public CircularArrayQueue(int size) {
		this.size =size;
		this.rear = -1;
		this.front = -1;
	}
	
	public void enqueue(int data) {
		if ((rear+1) % size != front) {
			rear = (rear+1) % size;
			queue[rear] = data;
		}
	}
	
	public int dequeue() throws Exception {
		int data = queue[front];
		if (front == rear) { 
			front = rear = -1; //queue is empty
		}else {
			front = (front+1)%size;
		}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
