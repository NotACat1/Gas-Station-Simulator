package com.example.lr3_2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lr3_2.data.FuelRepository
import com.example.lr3_2.model.FuelType

/**
 * ViewModel для управления бизнес-логикой приложения АЗС.
 *
 * Отвечает за взаимодействие с [FuelRepository], обработку продаж топлива
 * и предоставление данных для UI. Хранит состояние смены и итоговые данные.
 */
class FuelViewModel : ViewModel() {

    /** Репозиторий для хранения и обработки информации о продажах топлива. */
    private val repository = FuelRepository()

    /**
     * Добавляет новую запись о продаже.
     *
     * @param fuel Вид топлива.
     * @param liters Количество заправленного топлива (в литрах).
     */
    fun addSale(fuel: FuelType, liters: Double) {
        repository.addSale(fuel, liters)
    }

    /**
     * Возвращает список всех продаж за текущую смену.
     *
     * @return Список данных о продажах по каждому виду топлива.
     */
    fun getSales() = repository.getSales()

    /**
     * Возвращает общую сумму выручки за смену.
     *
     * @return Сумма всех продаж (в рублях).
     */
    fun getTotalRevenue() = repository.getTotalRevenue()

    /**
     * Очищает все данные о продажах (например, при завершении смены).
     */
    fun clearSales() = repository.clear()
}
