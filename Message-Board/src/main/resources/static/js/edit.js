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
    // 为表单添加验证
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function(e) {
            if (!validateForm(this)) {
                e.preventDefault();
            }
        });
    }

    // 为取消按钮添加返回确认
    const cancelButton = document.querySelector('.btn-cancel');
    if (cancelButton) {
        cancelButton.addEventListener('click', function(e) {
            if (form.querySelector('#content').value.trim() !== '') {
                if (!confirm('确定要放弃编辑吗？')) {
                    e.preventDefault();
                }
            }
        });
    }

    const textarea = document.getElementById('content');

    if (textarea) {
        textarea.addEventListener('focus', function() {
            this.style.borderColor = '#007bff';
            this.style.boxShadow = '0 0 8px rgba(0, 123, 255, 0.2)';
        });

        textarea.addEventListener('blur', function() {
            this.style.borderColor = '#ccc';
            this.style.boxShadow = 'none';
        });
    }

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