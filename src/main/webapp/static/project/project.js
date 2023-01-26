function updateManager(manager){
    $('#idGerente').val(manager);
}

function deleteProject(id){
    $.ajax({
        url: '/project/'+id,
        type: 'DELETE',
        success: function() {
            location.reload();
        }
    });
}