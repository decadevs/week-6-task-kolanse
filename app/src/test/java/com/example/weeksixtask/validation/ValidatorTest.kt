package com.example.weeksixtask.validation

import org.junit.Test

import org.junit.Assert.*

class ValidatorTest {
    /**
     *instantiates Validator class
     */
    var validator = Validator()

    /**
     * initialises variable to be passed
     */
    private val correctName = "samuel"
    private val correctEmail = "esam@gmail.com"
    private val correctPhone = "08025292940"

    private val inCorrectName = "232"
    private val inCorrectEmail = "esam"
    private val inCorrectPhone = "08025292"

    /**
     * checks whether emailIsValid method works correctly
     */
    @Test
    fun isEmailValidTest() {

        assertTrue(validator.isEmailValid(correctEmail))
        assertFalse(validator.isEmailValid(inCorrectEmail))

    }

    /**
     *  checks whether the phoneNumberValid method works correctly
     */

    @Test
    fun isPhoneNumberValidTest() {
        assertTrue(validator.isPhoneNumberValid(correctPhone))
        assertFalse(validator.isPhoneNumberValid(inCorrectPhone))
    }

    /**
     * checks whether the nameIsValid method works correctl
     */
    @Test
    fun isNameValidTest() {
        assertTrue(validator.isNameValid(correctName))
        assertFalse(validator.isNameValid(inCorrectName))
    }

    /**
     * checks whether theGenderValid method works correctly
     */

    @Test
    fun isGenderValidTest() {
        assertTrue(validator.isGenderValid("Male"))
        assertFalse(validator.isGenderValid("Tress"))
    }


    /**
     * checks the allValid methods
     */
    @Test
    fun isAllValidTest() {
        val validatorTrue = Validator()
        val validatorFalse = Validator()


        //pass in the true values into the validatorTrue
        validatorTrue.isGenderValid("Male")
        validatorTrue.isNameValid(correctName)
        validatorTrue.isPhoneNumberValid(correctPhone)
        validatorTrue.isEmailValid(correctEmail)

        assertTrue(validatorTrue.isAllValid())

        //pass in the false values into the validatorfalse

        validatorFalse.isEmailValid(inCorrectEmail)
        validatorFalse.isGenderValid("Male")
        validatorFalse.isNameValid(correctName)
        validatorFalse.isPhoneNumberValid(correctPhone)

        assertFalse(validatorFalse.isAllValid())

    }
}