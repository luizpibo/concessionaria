# Despensa doméstica

## Objetivo

 Criar uma API com todas as funções para o gerenciamento de consumo de uma despensa doméstica. O usuário poderá criar uma depensa e pode cadastrar outros usuários que poderam utilizala, essa despensa possui produtos de cozinha e higiene domestica e pessoal.

## Tabelas

user{
 id
 userName
 email
 password
 actived
}

pantry{
 id
 wornerId 
}

product{
 id
 name
 type
 amount
}

## Relações

user has pantry
pantry bellow user
pantry hasMany product