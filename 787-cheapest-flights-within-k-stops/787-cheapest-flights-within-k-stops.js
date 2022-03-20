/**
 * @param {number} n
 * @param {number[][]} flights
 * @param {number} src
 * @param {number} dst
 * @param {number} k
 * @return {number}
 */
var findCheapestPrice = function(n, flights, src, dst, k) {
    let prices = Array(n).fill(Number.MAX_SAFE_INTEGER)
    prices[src] = 0
    
    for (let i = 0; i < k + 1; i++) {
        const tmp = prices.slice()
        for (let [s, d, p] of flights) {
            if (prices[s] === Number.MAX_SAFE_INTEGER) continue // we need to start from 0
            
            tmp[d] = Math.min(tmp[d], prices[s] + p) // calculate cost from src to dst, update if it is smaller
        }
        
        prices = tmp
    }
    
    return prices[dst] === Number.MAX_SAFE_INTEGER ? -1 : prices[dst] // return -1 if there is no route to dst
};