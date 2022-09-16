<!--Nomes: Henrique Trajano (20103033) e Pedro Tigre (20104930)-->

# Trabalho ULA (Circuit Verse)

<br />

<div align="center">
  <a href="https://circuitverse.org/simulator/embed/trabalho-ula"> ⭅| clique aqui para acessar a ULA |⭆ </a>
</div>

### Como utilizá-la corretamente?

<p>Para um correto funcionamento da ULA deve-se colocar os respectivos números de A e B nos inputs na região mais a esquerda do circuito. Eles serão responsáveis por armazenar os operandos da operação, sendo A o primeiro operando e B o segundo operando.</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189922470-40ea49ce-ad91-4099-95b8-bd7d650b9de5.png" width="45%">
</div>

<br />
<p>Para realizar operações de subtração, <strong>o binvert deve ser selecionado manualmente para 1</strong>. Conforme a imagem abaixo:</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189923732-b8545216-a8f9-4d15-b110-60631a0b0ff1.png" width="45%">
</div>

<br />
<p>Para qualquer operação diferente de subtração,  <strong>o binvert deve ser configurado manualmente para 0</strong>. Conforme a imagem abaixo:</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189924178-f27fba58-b796-49f3-9645-483e9dfe122d.png" width="45%">
</div>

<br />
<p>O tipo de operação deve ser selecionado nos inputs localizados abaixo dos inputs do operando B, para realizar <strong>uma SOMA (binvert = 0) ou SUBTRAÇÃO (binvert = 1)</strong>, os inputs devem ser respectivamente  <strong>0 0</strong>, para realizar uma operação AND os inputs devem ser respectivamente 0 1, para realizar uma operação OR os inputs devem ser respectivamente <strong>1 0</strong> e para realizar uma operação XOR os inputs devem ser respectivamente <strong>1 1</strong>. Imagem do selecionador de operações (conectado ao multiplexador 4x1):</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189932391-1531ee46-a96d-4a99-ab03-01707c72684a.png" width="45%">
</div>

<br />
<p>Após inserir os operandos e selecionar a operação desejada, deve-se clicar no pulse chamado RESET GERAL, ele será responsável por salvar todos os inputs inseridos nos registradores. É importante realizar o pulse RESET GERAL antes de qualquer operação a fim de evitar bugs.</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189933491-40f31637-b4cc-4b8f-8fc1-1e9d30652ec2.png" width="45%">
</div>

<br />
<p>Ao clicar no RESET GERAL, os números selecionados nos inputs dos operando A e B aparecerão nos displays hexadecimais. Veja a imagem de demonstração:</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189934278-c1a2fb59-82f1-459e-a765-aa344cf74a3b.png" width="85%">
</div>

<br />
<p>Após clicar no pulse RESET, deve-se clicar 8 vezes no pulse denominado PULSO. E após clicar 8 vezes, o resultado da operação irá aparecer no display hexadecimal do operando A.</p>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189934950-65b98e8d-19c7-4c22-8ef5-d0fe86a053b7.png" width="45%">
</div>

<br />
<div align="center">
<p>Imagem mostrando o resultado da operação (5 + 4):</p>
</div>

<div align="center">
  <img src="https://user-images.githubusercontent.com/69161086/189935119-154f19f3-0599-4ae6-974e-c7592c31f986.png" width="45%">
</div>

<br />
<div align="center">
<p>Para realizar mais operações, basta colocar os novos operandos nos inputs de A e B, podendo acatar exatamente o fluxo descrito anteriormente para desempenhar um novo procedimento.</p>
</div>

<br />
<br />

### Exemplos

> Operação: ADIÇÃO 
>
>> A ➤ 10010011 ⟼ 93 HEX | 147 DEC
>>
>> B ➤ 00110001 ⟼ 31 HEX | 49 DEC
>>
>> Resultado: 11000100 ⟼ C4 HEX | 196 DEC
<br />

> Operação: ADIÇÃO 
>
>> A ➤ 10100001 ⟼ A1 HEX | 161 DEC
>>
>> B ➤ 00111010 ⟼ 3A HEX | 58 DEC
>>
>> Resultado: 11011011 ⟼ DB HEX | 219 DEC
<br />

> Operação: SUBTRAÇÃO 
>
>> A ➤ 11000011 ⟼ C3 HEX | 195 DEC
>>
>> B ➤ 00101011 ⟼ 2B HEX | 43 DEC
>>
>> Resultado: 10011000 ⟼ 98 HEX | 152 DEC
<br />

> Operação: SUBTRAÇÃO 
>
>> A ➤ 00100111 ⟼ 27 HEX | 39 DEC
>>
>> B ➤ 00000011 ⟼ 03 HEX | 3 DEC
>>
>> Resultado: 00100100 ⟼ 24 HEX | 36 DEC
<br />

> Operação: AND
>
>> A ➤ 10101111 ⟼ A7 HEX
>>
>> B ➤ 11110101 ⟼ F5 HEX
>>
>> Resultado: 10100101 ⟼ A5 HEX
<br />

> Operação: OR
>
>> A ➤ 10010001 ⟼ 91 HEX
>>
>> B ➤ 01001001 ⟼ 49 HEX
>>
>> Resultado: 11011001 ⟼ D9 HEX
<br />

> Operação: XOR
>
>> A ➤ 10111001 ⟼ B9 HEX
>>
>> B ➤ 10001110 ⟼ 8E HEX
>>
>> Resultado: 00110111 ⟼ 37 HEX

