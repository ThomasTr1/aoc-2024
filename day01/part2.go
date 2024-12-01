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

func readFileInput(file string) ([]int, map[int]int) {
	f, err := os.Open(file)
	if err != nil {
		log.Fatal("Error when opening file: ", err)
		return nil, nil
	}
	defer f.Close()

	scanner := bufio.NewScanner(f)

	leftList, rightOccurenceMap := readAllNumbersFromInput(scanner)

	return leftList, rightOccurenceMap
}

func readAllNumbersFromInput(scanner *bufio.Scanner) ([]int, map[int]int) {
	var leftList []int
	var rightOccurenceMap = make(map[int]int)
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
		rightOccurenceMap[rightNum]++
	}
	return leftList, rightOccurenceMap
}

func calculateSimilarScore(left []int, rightOccurenceMap map[int]int) []int {
	result := make([]int, len(left))

	for i, leftValue := range left {
		occurence, ok := rightOccurenceMap[leftValue]
		var score int
		if ok {
			score = leftValue * occurence
		}
		result[i] = score
	}
	return result
}

func main() {
	left, rightOccurenceMap := readFileInput("input")
	sort.Ints(left)

	similarScoreArray := calculateSimilarScore(left, rightOccurenceMap)

	var totalDistance int
	for _, distance := range similarScoreArray {
		totalDistance += distance
	}
	fmt.Printf("The total distance between the left and right list is: %d\n", totalDistance)
}
