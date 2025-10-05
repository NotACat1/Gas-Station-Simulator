package com.example.lr3_2.data

import com.example.lr3_2.model.FuelType

class FuelRepository {
    private val sales = mutableMapOf<FuelType, Double>()

    fun addSale(fuel: FuelType, liters: Double) {
        sales[fuel] = (sales[fuel] ?: 0.0) + liters
    }

    fun getSales(): Map<FuelType, Double> = sales

    fun getTotalRevenue(): Double {
        return sales.entries.sumOf { (fuel, liters) -> liters * fuel.pricePerLiter }
    }

    fun clear() {
        sales.clear()
    }
}