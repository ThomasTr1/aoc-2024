package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"sort"
	"strconv"
	"strings"
)

func readFileInputp1(file string) ([]int, []int) {
	f, err := os.Open(file)
	if err != nil {
		log.Fatal("Error when opening file: ", err)
		return nil, nil
	}
	defer f.Close()

	scanner := bufio.NewScanner(f)

	leftList, rightList := readAllNumbersFromInputp1(scanner)

	return leftList, rightList
}

func readAllNumbersFromInputp1(scanner *bufio.Scanner) ([]int, []int) {
	var leftList []int
	var rightList []int
	for scanner.Scan() {
		line := scanner.Text()
		numbers := strings.Fields(line)

		leftNum, err := strconv.Atoi(numbers[0])
		if err != nil {
			log.Fatal(err)
		}

		rightNum, err := strconv.Atoi(numbers[1])
		if err != nil {
			log.Fatal(err)
		}

		leftList = append(leftList, leftNum)
		rightList = append(rightList, rightNum)
	}
	return leftList, rightList
}

func calculateDistanceArrayp1(left []int, right []int) []int {
	result := make([]int, len(left))

	for i := range right {
		distance := left[i] - right[i]
		result[i] = absp1(distance)
	}
	return result
}

func absp1(x int) int {
	if x >= -x {
		return x
	}
	return -x

}

func mainp1() {
	left, right := readFileInputp1("input")
	sort.Ints(left)
	sort.Ints(right)

	if len(left) != len(right) {
		log.Fatal("Input arrays have a different length")
	}
	distanceArray := calculateDistanceArrayp1(left, right)

	var totalDistance int
	for _, distance := range distanceArray {
		totalDistance += distance
	}
	fmt.Printf("The total distance between the left and right list is: %d\n", totalDistance)
}
