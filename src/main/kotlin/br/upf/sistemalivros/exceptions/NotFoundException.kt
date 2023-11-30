package br.upf.sistemalivros.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()