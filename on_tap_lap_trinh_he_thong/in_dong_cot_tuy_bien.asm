code segment
    assume cs:code, ds:code
    org 100h
start:
    mov ah, 1
    int 21h  
    
    mov ah, 2 
    mov bh, 0
    mov dh, 20
    mov dl, 10
    int 10h 
              
    mov ah, 2
    mov dl, al
    int 21h 
    
    mov ah, 9
    lea dx, chuoi
    int 21h
    
    

chuoi db "DH Kien Truc$" 
mov ax, 4c00h
int 21h  

ends

end start