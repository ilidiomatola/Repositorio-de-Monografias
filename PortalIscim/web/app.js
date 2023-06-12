/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function convertFileToArray() {
    var fileInput = document.getElementById('fileInput');
    var fileArray = fileInput.files;

    var fileArrayInput = document.getElementById('monografia');
    fileArrayInput.value = JSON.stringify(Array.from(fileArray));
}


function actualizar_convertFileToArray() {
    var fileInput = document.getElementById('actualizar_fileInput');
    var fileArray = fileInput.files;

    var fileArrayInput = document.getElementById('actualizar_monografia');
    fileArrayInput.value = JSON.stringify(Array.from(fileArray));
}
