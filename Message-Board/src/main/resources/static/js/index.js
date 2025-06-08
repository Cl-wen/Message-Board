// 显示提示消息
function showToast(message, type = 'success') {
    const toast = document.createElement('div');
    toast.className = `toast toast-${type}`;
    toast.textContent = message;
    document.body.appendChild(toast);

    // 添加显示动画
    setTimeout(() => toast.classList.add('show'), 100);

    // 3秒后移除
    setTimeout(() => {
        toast.classList.remove('show');
        setTimeout(() => toast.remove(), 300);
    }, 3000);
}

// 添加表格行动画
function addTableRowAnimation() {
    const rows = document.querySelectorAll('tbody tr');
    rows.forEach((row, index) => {
        row.style.animationDelay = `${index * 0.1}s`;
        row.classList.add('fade-in');
    });
}

// 添加表单验证
function validateForm(form) {
    const author = form.querySelector('#author').value.trim();
    const content = form.querySelector('#content').value.trim();

    if (!author) {
        showToast('请输入发布者名称', 'error');
        return false;
    }
    if (!content) {
        showToast('请输入留言内容', 'error');
        return false;
    }
    return true;
}

// 页面加载完成后执行
document.addEventListener('DOMContentLoaded', function() {
    // 添加表格行动画
    addTableRowAnimation();

    // 为表单添加验证
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function(e) {
            if (!validateForm(this)) {
                e.preventDefault();
            }
        });
    }

    // 为删除按钮添加确认动画
    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(btn => {
        btn.addEventListener('click', function(e) {
            if (!confirm('确定要删除这条留言吗？')) {
                e.preventDefault();
            }
        });
    });

    const inputs = document.querySelectorAll('.input-group input, .input-group textarea');

    inputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.style.borderColor = '#007bff';
            this.style.boxShadow = '0 0 8px rgba(0, 123, 255, 0.2)';
        });

        input.addEventListener('blur', function() {
            this.style.borderColor = '#ccc';
            this.style.boxShadow = 'none';
        });
    });

    // 页面加载动画
    document.body.style.opacity = '0';
    setTimeout(() => {
        document.body.style.transition = 'opacity 0.5s ease';
        document.body.style.opacity = '1';
    }, 100);

    // 按钮悬停效果
    const buttons = document.querySelectorAll('.btn');
    buttons.forEach(button => {
        button.addEventListener('mouseover', function() {
            this.style.transform = 'scale(1.05)';
        });
        button.addEventListener('mouseout', function() {
            this.style.transform = 'scale(1)';
        });
    });
}); 