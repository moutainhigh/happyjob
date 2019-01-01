function showModal(options){
    swal({
        title: '认证',
        text: '是否通过认证!',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '通过',
        cancelButtonText: '不通过',
        }).then(function(isConfirm) {
        if (isConfirm === true) {
            swal(
            'Deleted!',
            'Your imaginary file has been deleted.',
            'success'
            );
        
        } else if (isConfirm === false) {
            swal(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
            );
        
        } else {
            // Esc, close button or outside click
            // isConfirm is undefined
        }
    }); 
}